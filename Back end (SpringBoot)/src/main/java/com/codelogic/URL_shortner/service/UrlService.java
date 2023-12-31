package com.codelogic.URL_shortner.service;

import com.codelogic.URL_shortner.model.Url;
import com.codelogic.URL_shortner.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.codelogic.URL_shortner.logic.GenerateShortUrl.getShortUrl;
import static com.codelogic.URL_shortner.logic.GenerateShortUrl.isUrlValid;


@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;


    public String getOriginlUrl(String id) {

        return urlRepository.findByShortUrl(id);
    }

    public Url generateShortUrl(String url) {
        if(! isUrlValid(url)) {
            System.out.println("URL is not valid");
            return null;
        }
        Url urlObject = new Url();
        urlObject.setOriginalurl(url);
        urlObject.setShorturl(getShortUrl(url));

        return urlRepository.save(urlObject);
    }
}
