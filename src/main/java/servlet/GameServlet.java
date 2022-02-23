package servlet;

import dao.GameDAO;
import dao.PlayerDAO;
import model.Game;
import model.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "GameServlet", value = "/game-servlet")
public class GameServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        request.getRequestDispatcher("game.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        String title = req.getParameter("title");
        int minplayers = Integer.parseInt(req.getParameter("minplayers"));
        int maxplayers = Integer.parseInt(req.getParameter("maxplayers"));
        GameDAO gameDAO = new GameDAO();
        Game game = new Game(title, minplayers, maxplayers);
        gameDAO.create(game);
        resp.sendRedirect(req.getContextPath() + "/game-servlet");
    }
}