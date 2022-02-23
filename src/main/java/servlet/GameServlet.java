package servlet;

import dao.GameDAO;
import model.Game;

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
        GameDAO gameDAO = new GameDAO();
        ArrayList<Game> gameList = new ArrayList<>();
        gameList = (ArrayList<Game>) gameDAO.read();
        request.setAttribute("gameList", gameList);

        request.getRequestDispatcher("game.jsp").forward(request, response);
    }
}