CREATE TABLE if not exists `todo` (
                        `id` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
                        `text` VARCHAR(100) NULL DEFAULT '' COLLATE 'utf8_general_ci',
                        `done` TINYINT(1) NULL DEFAULT '0',
                        PRIMARY KEY (`id`) USING BTREE
)
    COLLATE='utf8_general_ci'
ENGINE=InnoDB