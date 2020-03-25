package judge;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/judge")
public class JudgeController {
    @PostMapping
    public ResponseEntity<ScoringResult> create(@RequestBody SubmissionInfo submissionInfo) {
        ScoringResult scoringResult = new ScoringResult();

        return new ResponseEntity<>(scoringResult, HttpStatus.OK);
    }
}
