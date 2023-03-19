package com.creativefusion.spring6restmvc.services;

import com.creativefusion.spring6restmvc.model.BeerCSVRecord;

import java.io.File;
import java.util.List;

/**
 * @author sm@creativefusion.net
 */
public interface BeerCsvService {
    List<BeerCSVRecord> convertCSV(File csvFile);
}
