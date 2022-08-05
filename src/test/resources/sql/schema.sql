DROP TABLE IF EXISTS `todo`;
CREATE TABLE `todo` (
                        `id` VARCHAR(100) NOT NULL ,
                        `text` VARCHAR(100) NULL DEFAULT '',
                        `done` TINYINT(1) NULL DEFAULT '0',
                        PRIMARY KEY (`id`)
);