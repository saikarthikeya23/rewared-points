package com.charter.rewardpoints.resource;

import com.charter.rewardpoints.dto.Reward;
import com.charter.rewardpoints.service.RewardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/rewards")
public class RewardResource {

    private RewardService rewardService;

    public RewardResource(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Reward> getRewardById(@PathVariable("customerId") Long customerId){
        return new ResponseEntity<>(rewardService.getCustomerRewards(customerId), HttpStatus.OK);
    }
}
