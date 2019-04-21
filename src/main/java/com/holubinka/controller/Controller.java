package com.holubinka.controller;

import com.holubinka.web.Request;
import com.holubinka.web.ViewModel;

public interface Controller {

    ViewModel process(Request req);

}
