package com.medify.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medify.entity.Medicine;
import com.medify.service.MedicineService;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/medicine")
public class MedicineController {

	@Autowired
    private MedicineService medicineService;

    @GetMapping
    public List<Medicine> getMedicine() {
        return medicineService.fetchAllMedicines();
    }

    @GetMapping("/{medicineId}")
    public Medicine getMedicine(@PathVariable Long medicineId) {
        return medicineService.getMedicineById(medicineId);
    }

    @PostMapping
    public ResponseEntity<Medicine> createMedicine(@RequestBody Medicine medicine) {
    	System.err.println("medicine..."+medicine.toString());
        Medicine savedMedicine = medicineService.saveMedicine(medicine);
        return ResponseEntity.ok(savedMedicine);
    }

    @PutMapping("/{medicineId}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable Long medicineId, @RequestBody Medicine medicine) {
        Medicine currentMedicine = medicineService.updateMedicineById(null, medicine);
        return ResponseEntity.ok(currentMedicine);
    }

    @DeleteMapping("/{medicineId}")
    public ResponseEntity<Medicine> deleteMedicine(@PathVariable Long medicineId) {
        medicineService.deleteMedicineById(medicineId);
        return ResponseEntity.ok().build();
    }

}
