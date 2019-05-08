package ikip;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletRequestGet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//getParameter metodu yardimi ile name alan bilgisini verdigimiz HTML elemanlarinin value degerlerine ulasabiliriz.
		String firstName = req.getParameter("ad");
		String lastName = req.getParameter("soyad");
		String gender = req.getParameter("cinsiyet");
		String maritalStatus = req.getParameter("medeni");
		String[] language = req.getParameterValues("dil");

		PrintWriter pw = resp.getWriter();

		pw.print("Cinsiyet:");
		pw.print(gender + "<br>sim:" + firstName + "<br>Soyad:" + lastName + "<br>Medeni Durum:");
		pw.print(maritalStatus + "<br>Diller:");
		if (language != null) {
			for (String str : language) {
				pw.print(str + " ");
			}
		}
		pw.print("");
		
		//getParameterNames() metodu bize request parametlerin ismini dondurecektir.
		Enumeration<String> paramNames = req.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			System.out.println(paramName);
		}

		Map<String, String[]> parameterMap = req.getParameterMap();

		for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
			System.out.println(entry.getKey() + " " + Arrays.asList(entry.getValue()));
		}
		
		//HTTP GET KULLANDIÐIMIZ ÝÇÝN PARAMETRELER URL'DE GÖNDERÝLÝR

	}
}
