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

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
     * @param idMin
     * @param minimumDetail
     * @return ResponseEntity ok
     * @throws RecordNotFoundException
     */
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Minimum> updateDepartment(
            @RequestParam(value = "id") int idMin, @RequestBody Minimum minimumDetail)
            throws RecordNotFoundException {
        Minimum minimum =
                minimumRepository
                        .findById(idMin)
                        .orElseThrow(() -> new RecordNotFoundException(idMin));
        minimum.setDepertmentId(minimumDetail.getDepertmentId());
        minimum.setMajor(minimumDetail.getMajor());
        minimum.setLevel(minimumDetail.getLevel());
        minimum.setNote(minimumDetail.getNote());
        final Minimum updatedMinimum = minimumRepository.save(minimum);
        logger.debug("**Update Department**", linkTo(methodOn(MinimumRestController.class).updateDepartment(idMin, minimumDetail)).withSelfRel());
        return ResponseEntity.ok(updatedMinimum);
    }

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
