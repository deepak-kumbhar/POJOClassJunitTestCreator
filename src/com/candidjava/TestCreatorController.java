package com.candidjava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDataServlet
 */
public class TestCreatorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestCreatorController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String className = request.getParameter("className");
		String variables = request.getParameter("variables");

		String classVariable = createClassVariable(className);
		String[] classVariableList = classVariable.split(" ");
		String[] finalVariables = createVariablesTest(variables, classVariableList[1]);


		if (className.isEmpty() || variables.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("details.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		} else {
			request.setAttribute("var", finalVariables);
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp?val=" + classVariable);
			rd.forward(request, response);
		}
	}

	private String[] createVariablesTest(String variables, String classVariableList) {
		String[] tempString = variables.split(";");
		String[] finalString = new String[tempString.length * 2];
		int i = 0;
		for (String string : tempString) {
			String[] singleVariable = string.split(" ");
			if (singleVariable[1].equals("String")) {
				finalString[i] = classVariableList + ".set"
						+ (Character.toUpperCase(singleVariable[2].charAt(0)) + singleVariable[2].substring(1)) + "("
						+'"'+ singleVariable[2] +'"'+ ");";
				i++;

				finalString[i] = "assertEquals(" + '"' + singleVariable[2] + '"' + "," + classVariableList + ".get"
						+ (Character.toUpperCase(singleVariable[2].charAt(0)) + singleVariable[2].substring(1))+"());";
				i++;

			} else if (singleVariable[1].equals("Integer") || singleVariable[1].equals("int")
					|| singleVariable[1].equals("Double") || singleVariable[1].equals("double")) {
				finalString[i] = classVariableList + ".set"
						+ (Character.toUpperCase(singleVariable[2].charAt(0)) + singleVariable[2].substring(1)) + "("
						+ 1 + ");";
				i++;
				
				finalString[i] = "assertEquals(" +  1  + "," + classVariableList + ".get"
						+ (Character.toUpperCase(singleVariable[2].charAt(0)) + singleVariable[2].substring(1))+"());";
				i++;

			} else if (singleVariable[1].equals("Boolean") || singleVariable[1].equals("boolean")) {
				finalString[i] = classVariableList + ".set"
						+ (Character.toUpperCase(singleVariable[2].charAt(0)) + singleVariable[2].substring(1)) + "("
						+ true + ");";
				i++;

				finalString[i] = "assertEquals(" +  true  + "," + classVariableList + ".get"
						+ (Character.toUpperCase(singleVariable[2].charAt(0)) + singleVariable[2].substring(1))+"());";
				i++;
			}

		}

		return finalString;
	}

	private String createClassVariable(String className) {
		return className + " " + (Character.toLowerCase(className.charAt(0)) + className.substring(1)) + " = new "
				+ className + "();";
	}

}
