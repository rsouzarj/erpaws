package Util;

import java.io.File;
import java.io.PrintStream;
import java.net.URLDecoder;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.WebServlet({ "/image/*" })
public class ImageServlet extends javax.servlet.http.HttpServlet {
	private String imagePath;

	public void init() throws ServletException {
		System.out.println("Iniciou o método...");
		this.imagePath = "/Users/diogo.lima/dev/projetos/aws/src/main/webapp/";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		String requestedImage = request.getPathInfo();

		if (requestedImage == null) {

			response.sendError(404);
			return;
		}

		File image = new File(this.imagePath, URLDecoder.decode(requestedImage, "UTF-8"));

		if (!image.exists()) {

			response.sendError(404);
			return;
		}

		String contentType = getServletContext().getMimeType(image.getName());

		if ((contentType == null) || (!contentType.startsWith("image"))) {

			response.sendError(404);
			return;
		}

		response.reset();
		response.setContentType(contentType);
		response.setHeader("Content-Length", String.valueOf(image.length()));

		Files.copy(image.toPath(), response.getOutputStream());
	}
}

