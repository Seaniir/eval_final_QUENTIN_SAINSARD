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

@WebServlet(name = "PlayerServlet", value = "/player-servlet")
public class PlayerServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        request.getRequestDispatcher("player.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        String email = req.getParameter("email");
        String nickname = req.getParameter("nickname");
        PlayerDAO playerDAO = new PlayerDAO();
        Player player = new Player(email, nickname);
        playerDAO.create(player);
        resp.sendRedirect(req.getContextPath() + "/player-servlet");
    }
}