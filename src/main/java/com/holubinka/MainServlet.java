package com.holubinka;

import com.holubinka.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {

    private static final Map<Request,Controller> controllerMap = new HashMap<>();

    static {
        controllerMap.put(Request.of("GET","/servlet/login"),Factory.getLoginPageControler());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Request request = Request.of(req.getMethod(), req.getRequestURI());
        Controller controller = controllerMap.getOrDefault(request,r-> ViewModel.of("404"));
        ViewModel vm = controller.process(request);
        processViewModel(vm, req, resp);
    }

    private void processViewModel(ViewModel vm, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //vm.getAttributes().forEach((k,v)-> req.setAttribute(k,v));
        vm.getAttributes().forEach(req::setAttribute);

        req.getRequestDispatcher(vm.getRedirectUri()).forward(req, resp);
    }
}
