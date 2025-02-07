package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.Publisher;
import com.korit.springboot_study.mapper.PublisherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PublisherRepository {

    @Autowired
    private PublisherMapper publisherMapper;

        public Optional<List<Publisher>> findPublisherAll() {
            List<Publisher> foundPublishers = publisherMapper.selectPublishersAll();

            if (foundPublishers.isEmpty()) {
                return Optional.empty();
            }

            return foundPublishers.isEmpty()
                    ? Optional.empty()
                    : Optional.ofNullable(foundPublishers);
        }

}
