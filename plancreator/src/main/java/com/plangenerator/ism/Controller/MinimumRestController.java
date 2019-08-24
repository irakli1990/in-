package com.plangenerator.ism.Controller;

import com.plangenerator.ism.Model.Minimum;
import com.plangenerator.ism.Repository.MinimumRepository;
import com.plangenerator.ism.exceptions.RecordNotFoundException;
import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Irakli Kardava
 */
@RestController
@RequestMapping("/api/v1/minimum")
public class MinimumRestController {

    @Autowired
    private MinimumRepository minimumRepository;


    Logger logger = LoggerFactory.getLogger(MinimumRestController.class);


    /**
     *
     * @param id
     * @return Department json object
     */
    @GetMapping
    @ResponseBody
    public Minimum findById(@RequestParam(value = "id") int id) {
        logger.debug("**Mimimum findById*", id);
        return minimumRepository.findAllByIdMin(id);
    }

    /**
     *
     * @param id
     * @return empty {@link ResponseEntity}
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteMinimum(@RequestParam(value = "id") int id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        Minimum minimum = findById(id);
        responseHeaders.set(minimum.getMajor(),
                "Is deleted");
        logger.debug("REST request to delete minimum : {}", id);
        minimumRepository.delete(findById(id));
        return ResponseEntity.ok().headers(responseHeaders).build();
    }

    /**
     *
     * @return ResponseEntity ok
     * @throws RecordNotFoundException
     */
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Minimum> updateDepartment(
            @RequestParam(value = "id") int id, @RequestBody Minimum minimumDetail)
            throws RecordNotFoundException {
        Minimum minimum =
                minimumRepository
                        .findById(id)
                        .orElseThrow(() -> new RecordNotFoundException(id));
        minimum.setDepertmentId(minimumDetail.getDepertmentId());
        minimum.setMajor(minimumDetail.getMajor());
        minimum.setLevel(minimumDetail.getLevel());
        minimum.setNote(minimumDetail.getNote());
        final Minimum updatedMinimum = minimumRepository.save(minimumDetail);
        logger.debug("**Update Minima**",id);
        return ResponseEntity.ok(updatedMinimum);
    }
//    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Minimum> updateMinima(@RequestBody Minimum minima) throws URISyntaxException {
//        logger.debug("REST request to update Minima : {}", minima);
//        Minimum result = minimumRepository.save(minima);
//        return ResponseEntity.ok().body(result);
//    }

    /**
     *
     * @param minimumDetail
     * @return ResponseEntity<Mimimum>
     * @throws RecordNotFoundException
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Minimum> saveDepartment(@RequestBody Minimum minimumDetail)
            throws RecordNotFoundException {
        logger.debug("**Update Department**", minimumDetail);
        return ResponseEntity.ok(minimumRepository.save(minimumDetail));
    }

}
