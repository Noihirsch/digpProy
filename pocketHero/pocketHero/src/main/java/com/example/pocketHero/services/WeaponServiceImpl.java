package com.example.pocketHero.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pocketHero.domains.creation.Weapon;
import com.example.pocketHero.repositories.WeaponRepository;

@Service
public class WeaponServiceImpl implements WeaponService {
    
    @Autowired
    private WeaponRepository weaponRepository;

    @Override
    public List<Weapon> getAllWeapons(){
        return weaponRepository.findAll();
    }

    @Override
    public Weapon getWeaponById(Long id){
        return weaponRepository.findById(id).get();
    }

    public Weapon newWeapon(Weapon weapon){
        return weaponRepository.save(weapon);
    }

    public Weapon updateWeapon(Weapon weapon){
        return weaponRepository.save(weapon);
    }

    public void deleteWeapon(Long id){
        weaponRepository.deleteById(id);
    }

    public Weapon getWeaponByName(String name){
        return weaponRepository.findByName(name);
    }



    
}
