INSERT INTO group_aggregate(name_target, img_url, parent_id, type_of_children, descript)
VALUES ('Хортичанка', 'hortichanka.jpg', 0, 1, 'Some very important description'),
       ('Eugenia', 'eugenia.png', 0, 1, 'Some very important description'),
('Хлебопекарское оборудование', 'hortichanka_equipment.jpg', 1, 1, 'Some very important description'),
('Специальное хлебопекарское оборудование', 'hortichanka_spec_equipment.jpg', 3, 2, 'Some very important description'),
('Вспомагательное хлебопекарское оборудование', 'hortichanka_aux_equipment.jpg', 3, 2, 'Some very important description'),
('Швейное оборудование', 'eugenia_spec_equipment.png', 2, 1, 'Some very important description'),
('Швейное основное оборудование', 'eugenia_spec_equipment.png', 6, 2, 'Some very important description'),
('Швейное вспомагательнле оборудование', 'eugenia_aux_equipment.jpg', 6, 2, 'Some very important description');

INSERT INTO provider(name_provider, descript, internet_address, phisical_address, email, phone, img_url)
VALUES ('Степан Чмырь', '', '', '', '0676112211,', 'noneImg'),
('Revent', 'http://www.revent.com/,', '', 'info@revent.se,', '+460859000600,', 'revent.jpg'),
('SNB-COMPANY', 'https://snb-company.com/,', 'г. Киев, ул. Коллекторная, 3 офис 205',
'snb-company@ukr.net', '0800330007,0997000303,0987000303,0937000303,', 'snb-kompani.png'),
('Виталий', '', 'Сергей - заместитель по производству тел. 0662920388', '', '', '0972778250,', '');

INSERT INTO aggregate(name_target, img_url, descript, parent_id, group_id, quantity, serial_key)
VALUES ('Revent 724 печь №1', 'revent724.jpg,', '', 0, 4, 3, '№1'),
('Телега для печи revent 724, 15 ярусов', 'телега_revent_724_15.jpg,', '15 ярусов', 1, 4, 12, ''),
('Термостойкое колесо с поворотным механизмом', 'термостойкое_колусо.jpg,', '', 2, 4, 4, ''),

INSERT INTO aggregate_provider(id_aggregate, id_provider)
VALUES (1, 1), (1, 2), (2, 4), (3, 3);

