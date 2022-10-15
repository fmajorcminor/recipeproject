package com.fmajorcminor.recipeproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final static Logger logger = Logger.getLogger(IngredientController.class.getName());

}
