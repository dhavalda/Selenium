package utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	static JSONArray jsonObj = new JSONArray();
	static JSONObject assessmentsObj = new JSONObject();
	static JSONArray questionsJson = new JSONArray();

	public static void main(String[] args) {
		// Directory where the files are located
		File dir = new File("AssessmentItemFiles");

		// Create a FileFilter that matches ".xml" files
		FileFilter filter = (File file) -> file.isFile() && file.getName().endsWith(".xml");

		// Get pathnames of matching files.
		File[] paths = dir.listFiles(filter);
		for (int i = 0; i < paths.length; i++) {
			String fileName = paths[i].getName();
			createJSON(fileName, paths, i);
		}
		
		FileWriter file;
		try {
			file = new FileWriter(System.getProperty("user.dir") + "\\Results\\assessments.json");
			file.write(assessmentsObj.toJSONString());
			file.close();
		} catch (IOException e) {
		}
	}


	public static void createJSON(String fileName, File[] paths, int count) {
		JSONObject mainJson = new JSONObject();
		Assessments Assessment = new Assessments();
		Assessments.Questions questions = Assessment.new Questions();
		addJsonObject("(.*).xml", fileName, Assessment, "OID", mainJson);
		addJsonObject("([0-9](.[0-9]*)).xml", fileName, Assessment, "Version", mainJson);
		addJsonObject("_([a-zA-Z]*)_", fileName, Assessment, "Language", mainJson);
		addJsonObject("ravenna_([0-9])*_", fileName, Assessment, "CourseNumber", mainJson);
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		Document doc = null;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		try {
			doc = dBuilder.parse(paths[0]);
		} catch (Exception e) {
		}

		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("item");

		for (int j = 0; j < nList.getLength(); j++) {
			JSONArray questionsList = new JSONArray();
			JSONArray answersList = new JSONArray();
			JSONArray incorrAnswersList = new JSONArray();
			questions.IncorrectAnswers = new ArrayList<String>();
			questions.CorrectAnswers = new ArrayList<String>();
			questions.Question = new ArrayList<String>();

			Element element = (Element) nList.item(j);
			if (element.getElementsByTagName("mattext").item(0) != null) {
				questions.Question.add(element.getElementsByTagName("mattext").item(0).getTextContent());
				if (!questionsList.contains(questions.Question)) {
					questionsList.add(element.getElementsByTagName("mattext").item(0).getTextContent());
				}
			}
			
            if(element.getElementsByTagName("matflashparam").item(0) != null) {
				 String uri = element.getElementsByTagName("matflashparam").item(0).getAttributes().getNamedItem("uri").getNodeValue();
				 uri = uri.replaceAll("file:", "");
//				 System.out.println("uri value is: " +uri);
				 
				// Directory where the files are located
					File dirD = new File("AssessmentItemFiles/DandD");

					// Create a FileFilter that matches ".xml" files
					FileFilter filterD = (File file) -> file.isFile() && file.getName().endsWith(".xml");

					// Get pathnames of matching files.
					File[] pathD = dirD.listFiles(filterD);
					
//					System.out.println(pathD);
					String file = null;
					for (int i = 0; i < pathD.length; i++) {
                      	file = pathD[i].getName();
                      	System.out.println("file contains: "+file);
//						createJSON(file,pathD,i);
						
//						if(file.matches(uri)) {	
//							System.out.println(file.matches(uri));
//							break;
//						}
					//}
					
					String DandDQues = parseDandDQues(file,pathD,i);
					questionsList.add(DandDQues);
//					System.out.println("DND Question: "+(DandDQues));
					String DandDAns = parseDandDAns(file, pathD, i);
					answersList.add(DandDAns);
//					System.out.println(" DND Answer: "+DandDAns);
					
		}
			}
            

			
			NodeList qList = element.getElementsByTagName("response_label");
			NodeList fList = element.getElementsByTagName("varequal");

			for (int k = 0; k < qList.getLength(); k++) {
				Element qElement = (Element) qList.item(k);
				if (qElement.getAttribute("rlcorrect").equals("No")) {
					if (qElement.getElementsByTagName("mattext").item(0) != null) {
						questions.IncorrectAnswers.add(qElement.getElementsByTagName("mattext").item(0).getTextContent());
						if (!incorrAnswersList.contains(questions.IncorrectAnswers)) {
							incorrAnswersList.add(questions.IncorrectAnswers);
						}
					}
				} else if (qElement.getAttribute("rlcorrect").equals("Yes")) {
					if (qElement.getElementsByTagName("mattext").item(0) != null) {
						questions.CorrectAnswers.add(qElement.getElementsByTagName("mattext").item(0).getTextContent());
						if (!answersList.contains(questions.CorrectAnswers)) {
							answersList.add(qElement.getElementsByTagName("mattext").item(0).getTextContent());
						}
					}
				}
			}
			
			if(answersList.size() < 1) {
				if(!questionsList.get(0).toString().contains("In your opinion")) {
					//questions.Question.add(element.getElementsByTagName("mattext").item(j).getTextContent());
					
					String type = element.getAttributes().getNamedItem("type").getNodeValue();
//					System.out.println(type);
					if(type.equalsIgnoreCase("FIB")) {
						for(int i=0; i<element.getElementsByTagName("mattext").getLength(); i++) {
				 questions.Question.add(element.getElementsByTagName("mattext").item(i).getTextContent());
//							System.out.println(doubt);
//						}
						if (!questionsList.contains(questions.Question)) {
							questionsList.add(element.getElementsByTagName("mattext").item(i).getTextContent());
							//System.out.println(element.getElementsByTagName("mattext").item(i).getTextContent());
							
						}
						for(int k=0; k<fList.getLength(); k++) {
							Element qElement = (Element) fList.item(k);
							answersList.add(qElement.getTextContent());
						}
					}
				  }
				}
			}
			
			JSONObject obj = new JSONObject();
			obj.put("Question", questionsList);
			questionsJson.add(obj);
			obj = new JSONObject();
			obj.put("CorrectAnswers", answersList);
			questionsJson.add(obj);
			obj = new JSONObject();
			obj.put("IncorrectAnswers", incorrAnswersList);
			questionsJson.add(obj);
		}
		mainJson.put("questions", questionsJson);
		jsonObj.add(mainJson);
		assessmentsObj.put("Assessments", jsonObj.toString());
	}
	
	public static String parseDandDQues(String fileName, File paths[], int d) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		Document doc = null;
//		JSONArray list = new JSONArray();

		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		try {
			doc = dBuilder.parse(paths[d]);
		} catch (Exception e) {
		}

		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("text");
		String content = null;
//		int j = 0;
		for (int j = 0; j< nList.getLength(); j++) {
		//	System.out.println("nlist: "+nList.getLength());
			Element element =  (Element) nList.item(j);
//			System.out.println("Print nlist item number: "+element);
            content = element.getTextContent();
//			System.out.println("content: "+content);

			
			while(content.contains("<")) {
				int stInd = content.indexOf('>')+1;
				int enInd = content.lastIndexOf('<')-1;
				content = content.substring(stInd, enInd);
				break;
			}
			
			//System.out.println("J value is: " +j);
			
		}
		
	//	System.out.println("Print content after for loop: "+content);
		
		return content;
		
		
	}
	
	public static String parseDandDAns(String fileName, File paths[], int d) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		Document doc = null;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		try {
			doc = dBuilder.parse(paths[d]);
		} catch (Exception e) {
		}

		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("text");
		String content = null;
		for (int j = 0; j < nList.getLength(); j++) {
			Element element = (Element) nList.item(j);
			 if(element.getTextContent().contains("For full credit place the options in the following order") || (element.getTextContent().contains("Place the options in the following order:")))				
			 {
				 content = element.getTextContent();
				//System.out.println("DANDAns: "+content);
				break;
			}
		}
		return content;
	}
	public static void addJsonObject(String regex, String fileName, Assessments Assessment, 
			String object, JSONObject mainJson) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(fileName);

		if (matcher.find()) {
			mainJson.put(object, matcher.group(1));
		}
	}
}