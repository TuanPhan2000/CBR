package com.CBR.service.serviceImpl;

import com.CBR.enity.Log;
import com.CBR.repository.LogRepo;
import com.CBR.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogRepo logRepo;

    @Override
    public boolean saveLog(Log log) {
        try {
            logRepo.save(log);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
