ALTER TABLE `iot` ADD CONSTRAINT `FK_iot2beacon`
    FOREIGN KEY (`beacon_id`) REFERENCES `beacon` (`id`);
ALTER TABLE `beacon` ADD CONSTRAINT `FK_beacon2uid`
    FOREIGN KEY (`uid_id`) REFERENCES `uid` (`id`);
ALTER TABLE `beacon` ADD CONSTRAINT `FK_beacon2url`
    FOREIGN KEY (`url_id`) REFERENCES `url` (`id`);
ALTER TABLE `beacon` ADD CONSTRAINT `FK_beacon2tlm`
    FOREIGN KEY (`tlm_id`) REFERENCES `tlm` (`id`);