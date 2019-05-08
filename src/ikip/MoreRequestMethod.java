package ikip;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoreRequestMethod extends HttpServlet {
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		
		//get header ile header bilgilerine ulaþabiliriz. Burda Host bilgisine ulaþýldý.
		//hostHeader.getHeaderNames ile de tüm header bilgileri isim olarak geri döndürülür(ret Enumeration).
		//Bu isimleri de getHeader()'a parametre olarak yollayarak bilgileri alabiliriz.
		String hostHeader = req.getHeader("host");
		String serverName = req.getServerName();
		//server port requestin ilk karsilandigi basladigi porttur. local port ise bu istegin tamamlandigi porttur.
		int localPort = req.getLocalPort();
		int serverPort = req.getServerPort();
		int remotePort = req.getRemotePort();
		String method = req.getMethod();
		String contexPath = req.getContextPath();

		pw.println("<html><body>");
		pw.println("<table>");
		pw.println("<tr><td>host<td>" + hostHeader);
		Enumeration<String> headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			pw.println("<tr><td>" + headerName);
			pw.println("<td>" + req.getHeader(headerName));
		}

		pw.println("<tr><td>serverName<td>" + serverName);
		pw.println("<tr><td>localPort<td>" + localPort);
		pw.println("<tr><td>serverPort<td>" + serverPort);
		pw.println("<tr><td>remotePort<td>" + remotePort);
		pw.println("<tr><td>method<td>" + method);
		pw.println("<tr><td>contexPath<td>" + contexPath);
		pw.println("</table>");
		pw.println("</html></body>");

	}
}
