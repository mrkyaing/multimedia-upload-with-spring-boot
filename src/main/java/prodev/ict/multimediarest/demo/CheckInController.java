package prodev.ict.multimediarest.demo;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class CheckInController {
@Autowired
CheckInService checkInService;

@GetMapping(value = "/exportCheckInCSV", produces = "text/csv")
    public ResponseEntity<Resource> exportCSV(@RequestParam("from") Optional<LocalDate> from,
                                              @RequestParam("to") Optional<LocalDate> to) {
        String[] csvHeader = {"Id", "mobileUserId", "locationId","description"};
    List<CheckIn> csvBody=null;
        if (from.isPresent() && to.isPresent())
            csvBody=checkInService.findAllByCreatedDateBetween(from.get(),to.get());
        else
            csvBody=checkInService.getAllCheckIn();
        ByteArrayInputStream byteArrayOutputStream;

        try (
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                // defining the CSV printer
                CSVPrinter csvPrinter = new CSVPrinter(
                        new PrintWriter(out),
                        // withHeader is optional
                        CSVFormat.DEFAULT.withHeader(csvHeader)
                );
        ) {
            // populating the CSV content
            for (CheckIn b : csvBody)
                csvPrinter.printRecord(b.getId(),""+b.getMobileUserId(),""+b.getLocationId(),""+b.getDescription());
            // writing the underlying stream
            csvPrinter.flush();
            byteArrayOutputStream = new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        InputStreamResource fileInputStream = new InputStreamResource(byteArrayOutputStream);
        String csvFileName = "check.csv";
        // setting HTTP headers
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + csvFileName);
        // defining the custom Content-Type
        headers.set(HttpHeaders.CONTENT_TYPE, "text/csv");
        return new ResponseEntity(
                fileInputStream,
                headers,
                HttpStatus.OK
        );
    }
}
