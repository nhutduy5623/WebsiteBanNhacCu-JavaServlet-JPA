package control.web;

// RSSServlet.java
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import java.io.IOException;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rssReader")
public class RSSServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            URL feedSource = new URL("https://vnexpress.net/rss/khoa-hoc.rss");
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedSource));
            
            request.setAttribute("feed", feed);
            request.getRequestDispatcher("/rssReader.jsp").forward(request, response);
        } catch (FeedException e) {
            throw new ServletException("Problem parsing the RSS feed", e);
        }
    }
}
