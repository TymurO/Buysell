package com.example.buysell.service;

import com.example.buysell.module.Image;
import com.example.buysell.module.Product;
import com.example.buysell.repository.ImageRepository;
import com.example.buysell.util.ImageUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

//    public String uploadImage(MultipartFile file) throws IOException {
//        Image image = imageRepository.save(Image.builder()
//                .name(file.getOriginalFilename())
//                .type(file.getContentType())
//                .imageData(ImageUtils.compressImage(file.getBytes())).build());
//
//        if (image != null) {
//            return "file uploaded successfully: " + file.getOriginalFilename();
//        }
//        return null;
//    }
//

    @Transactional
    public Optional<Image> getImageById(Long id) {
        return imageRepository.getImageById(id);
    }
}
