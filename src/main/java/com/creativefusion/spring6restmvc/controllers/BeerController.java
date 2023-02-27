package com.creativefusion.spring6restmvc.controllers;

import com.creativefusion.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * @author sm@creativefusion.net
 */
@AllArgsConstructor
@Controller
public class BeerController {
    private final BeerService beerService;
}
