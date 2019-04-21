package com.holubinka.web;

import com.holubinka.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.holubinka.Factory.getAllCategoryController;
import static com.holubinka.Factory.getCategoryDao;
import static com.holubinka.Factory.getCategoryService;
import static com.holubinka.Factory.getConnection;
import static com.holubinka.Factory.getGetCategoryByIdController;
import static com.holubinka.Factory.getLoginUserController;
import static com.holubinka.Factory.getUserDaoImpl;
import static com.holubinka.Factory.getUserServiceImpl;

public class MainServlet extends HttpServlet {

    private static final Map<Request,Controller> controllerMap = new HashMap<>();

    static {
        controllerMap.put(Request.of("GET","/servlet/login"),r -> ViewModel.of("login"));
        controllerMap.put(Request.of("POST","/servlet/login"),getLoginUserController(getUserServiceImpl(getUserDaoImpl(getConnection()))));
        controllerMap.put(Request.of("GET","/servlet/categories"), getAllCategoryController(getCategoryService(getCategoryDao(getConnection()))));
        controllerMap.put(Request.of("GET","/servlet/category"), getGetCategoryByIdController(getCategoryService(getCategoryDao(getConnection()))));
        controllerMap.put(Request.of("GET","/servlet/admin"), r -> ViewModel.of("admin"));
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
        Request request = Request.of(req.getMethod(), req.getRequestURI(), req.getParameterMap());
        Controller controller = controllerMap.getOrDefault(request,r-> ViewModel.of("404"));
        ViewModel vm = controller.process(request);
        processViewModel(vm, req, resp);
    }

    private void processViewModel(ViewModel vm, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        vm.getAttributes().forEach(req::setAttribute);
        processCookie(vm.getCookies(),resp);
        req.getRequestDispatcher(vm.getRedirectUri()).forward(req, resp);
    }

    private void processCookie(List<Cookie> cookie, HttpServletResponse resp) {
        cookie.forEach(c -> resp.addCookie(new javax.servlet.http.Cookie(c.getName(), c.getValue())));
    }
}
