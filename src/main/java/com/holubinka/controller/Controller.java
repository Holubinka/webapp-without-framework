package com.holubinka.controller;

import com.holubinka.Request;
import com.holubinka.ViewModel;

public interface Controller {

    ViewModel process(Request req);

}
