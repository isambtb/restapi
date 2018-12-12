package com.bpm.medicament.app.services;


import com.bpm.medicament.app.domain.MedicinalProduct;
import com.bpm.medicament.app.repositories.MedicinalProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@Service
public class MedicinalProductService {

    @Autowired
    private MedicinalProductRepository medicinalProductRepository;



    /*

     This method receive the a SPL json Format
     then it compare it with the last version post by BlueWay
     if no last version found:
        save as new Version (first version)
     else if changes are detected:
        duplicate the last version of SPL
        set new version as last version
     else no Changes:
        Pass
     return the last version.

    */

    public MedicinalProduct saveMp(MedicinalProduct mp){
        MedicinalProduct lastVersionMp = medicinalProductRepository.getLastVersion(mp.getCode());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        if (lastVersionMp == null){
            mp.setIsLastVersion(true);
            mp.setVersionNumber(1);
            mp.setCreatedOn(dtf.format(now));
            return this.medicinalProductRepository.save(mp);
        }
        else if(!lastVersionMp.equals(mp)){
            mp.setVersionNumber(lastVersionMp.getVersionNumber() + 1);
            mp.setIsLastVersion(true);
            lastVersionMp.setIsLastVersion(false);
            mp.setCreatedOn(lastVersionMp.getCreatedOn());
            mp.setUpdatedOn(dtf.format(now));
            this.medicinalProductRepository.update(lastVersionMp.getId());
            return this.medicinalProductRepository.save(mp);
        }
        return lastVersionMp;
    }

    /*

     This method receive the a SPL json Format
     then it compare it with the last version post by Pharmacist
     if changes are detected:
        duplicate the last version of SPL
        set new version as last version
        set updated by
        Set updated date
     else no Changes:
        Pass
     return the last version.

    */

    public MedicinalProduct updateMp(MedicinalProduct mp){
        return mp;
    }

}
