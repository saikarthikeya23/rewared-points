package com.charter.rewardpoints.resource;

import com.charter.rewardpoints.dto.Reward;
import com.charter.rewardpoints.service.RewardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/rewards")
public class RewardResource {

    private RewardService rewardService;

    public RewardResource(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("/{customerId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Reward> getRewardById(@PathVariable("customerId") Long customerId){
        return new ResponseEntity<>(rewardService.getCustomerRewards(customerId), HttpStatus.OK);
    }
}
