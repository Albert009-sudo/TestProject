package com.example.testproject.Controller;

import com.example.testproject.Entity.Address;
import com.example.testproject.Service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Address>> getAddressesByCustomerId(@PathVariable Long customerId) {
        List<Address> addresses = addressService.getAddressesByCustomerId(customerId);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address savedAddress = addressService.saveAddress(address);
        return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        Address updatedAddress = addressService.updateAddress(id, address);
        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
