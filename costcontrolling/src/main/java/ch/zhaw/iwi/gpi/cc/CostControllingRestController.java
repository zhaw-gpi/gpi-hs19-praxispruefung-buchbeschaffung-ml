package ch.zhaw.iwi.gpi.cc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * CostControllingRestController
 */
@RestController
public class CostControllingRestController {

    @Autowired
    private VarianceRepository varianceRepository;

    @RequestMapping(path = "/api/v1/variances/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<Variance> getVariance(@PathVariable Long accountId) {
        Optional<Variance> variance = varianceRepository.findById(accountId);

        if(variance.isPresent()){
            return new ResponseEntity<Variance>(variance.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
}