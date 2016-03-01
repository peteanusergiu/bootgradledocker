ALTER TABLE `beacon` ADD CONSTRAINT `FK_beacon2iot`
    FOREIGN KEY (`iot_id`) REFERENCES `iot` (`id`);
ALTER TABLE `uid` ADD CONSTRAINT `FK_uid2beacon`
    FOREIGN KEY (`beacon_id`) REFERENCES `beacon` (`id`);
ALTER TABLE `url` ADD CONSTRAINT `FK_url2beacon`
    FOREIGN KEY (`beacon_id`) REFERENCES `beacon` (`id`);
ALTER TABLE `tlm` ADD CONSTRAINT `FK_tlm2beacon`
    FOREIGN KEY (`beacon_id`) REFERENCES `beacon` (`id`);