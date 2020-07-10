INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'ACTIVATE_USER_PERMISSION'); /*1*/
INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'DEACTIVATE_USER_PERMISSION'); /*2*/
INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'REMOVE_USER_PERMISSION'); /*3*/
INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'CREATE_USER_PERMISSION'); /*4*/
INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'CHANGE_USER_PERMISSION'); /*5*/

INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'CREATE_RENTAL_PERMISSION'); /*6*/
INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'CHANGE_RENTAL_PERMISSION'); /*7*/
INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'DELETE_RENTAL_PERMISSION'); /*8*/

INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'CREATE_REVIEW_PERMISSION'); /*9*/
INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'CHANGE_REVIEW_PERMISSION'); /*10*/
INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'DELETE_REVIEW_PERMISSION'); /*11*/

INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'APPROVE_REVIEW_PERMISSION'); /*12*/

INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'CREATE_VEHICLE_PART_PERMISSION'); /*13*/
INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'CHANGE_VEHICLE_PART_PERMISSION'); /*14*/
INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'DELETE_VEHICLE_PART_PERMISSION'); /*15*/

INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'CREATE_PRICELIST_PERMISSION'); /*16*/
INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'CHANGE_PRICELIST_PERMISSION'); /*17*/
INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'DELETE_PRICELIST_PERMISSION'); /*18*/
INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'VIEW_PRICELIST_PERMISSION'); /*19*/

INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'CREATE_VEHICLE_OCCUPANCY'); /*20*/
INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'CHANGE_VEHICLE_OCCUPANCY'); /*21*/
INSERT INTO permission(
    id, name)
    VALUES (nextval('permissions_id_seq'), 'DELETE_VEHICLE_OCCUPANCY'); /*22*/


INSERT INTO role(
    id, name)
    VALUES (nextval('roles_id_seq'), 'ROLE_ADMIN'); /*1*/
INSERT INTO role(
    id, name)
    VALUES (nextval('roles_id_seq'), 'ROLE_SIMPLE_USER'); /*2*/
INSERT INTO role(
    id, name)
    VALUES (nextval('roles_id_seq'), 'ROLE_VEHICLE_OWNER'); /*3 needed?*/
INSERT INTO role(
    id, name)
    VALUES (nextval('roles_id_seq'), 'ROLE_REGISTERED_USER'); /*4*/
INSERT INTO role(
    id, name)
    VALUES (nextval('roles_id_seq'), 'ROLE_AGENT_COMPANY'); /*5 not sure...*/


INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (1, 1);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (1, 2);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (1, 3);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (1, 4);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (1, 5);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (1, 12);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (1, 13);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (1, 14);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (1, 15);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (1, 16);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (1, 17);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (1, 18);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (1, 19);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (1, 20);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (1, 21);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (1, 22);

/*Add permissions to other users after consulting*/
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (2, 5);

INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (3, 5);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (3, 6);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (3, 7);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (3, 8);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (3, 9);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (3, 10);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (3, 11);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (3, 16);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (3, 17);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (3, 18);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (3, 19);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (3, 20);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (3, 21);
INSERT INTO role_permission(
    roles_id, permissions_id)
    VALUES (3, 22);

INSERT INTO users(
	id, address, city, email, name, password, phone_number, state, surname, enabled, deleted ) /*1*/
	VALUES (nextval('users_id_seq'), 'Vladimira Iljica Lenjina 1917', 'Moskva', 'admin@admin.rs', 'Vladimir', '$2a$10$ghTRgrttAM2LyW9ZmDLYK.qwgFY88bSzNqPOSL26DliJRmpjWx/3y', '067/123',  'Srbija', 'Lenjin', true, false);
INSERT INTO users(
	id, address, city, email, name, password, phone_number, state, surname, enabled, deleted ) /*2*/
	VALUES (nextval('users_id_seq'), 'Vladimira Iljica Lenjina 1917', 'Moskva', 'user@car2go.rs', 'Marko', '$2a$10$ghTRgrttAM2LyW9ZmDLYK.qwgFY88bSzNqPOSL26DliJRmpjWx/3y', '067/123',  'Srbija', 'Petrovic', true, false);
INSERT INTO users(
	id, address, city, email, name, password, phone_number, state, surname, enabled, deleted ) /*2*/
	VALUES (nextval('users_id_seq'), 'Vladimira Iljica Lenjina 1917', 'Moskva', 'user2@car2go.rs', 'Nikola', '$2a$10$ghTRgrttAM2LyW9ZmDLYK.qwgFY88bSzNqPOSL26DliJRmpjWx/3y', '067/123',  'Srbija', 'Markovic', true, false);
INSERT INTO users(
	id, address, city, email, name, password, phone_number, state, surname, enabled, deleted ) /*2*/
	VALUES (nextval('users_id_seq'), 'Vladimira Iljica Lenjina 1917', 'Moskva', 'user3@car2go.rs', 'Petar', '$2a$10$ghTRgrttAM2LyW9ZmDLYK.qwgFY88bSzNqPOSL26DliJRmpjWx/3y', '067/123',  'Srbija', 'Nikolic', true, false);
INSERT INTO users(
	id, address, city, email, name, password, phone_number, state, surname, enabled, deleted ) /*2*/
	VALUES (nextval('users_id_seq'), 'Vladimira Iljica Lenjina 1917', 'Moskva', 'user4@car2go.rs', 'Mihajlo', '$2a$10$ghTRgrttAM2LyW9ZmDLYK.qwgFY88bSzNqPOSL26DliJRmpjWx/3y', '067/123',  'Srbija', 'Petrovic', true, false);


/* LENJIN JE BOG */
INSERT INTO user_role(
    user_id, role_id)
    VALUES (1, 1);
INSERT INTO user_role(
    user_id, role_id)
    VALUES (1, 2);
INSERT INTO user_role(
    user_id, role_id)
    VALUES (1, 3);
INSERT INTO user_role(
    user_id, role_id)
    VALUES (1, 4);
INSERT INTO user_role(
    user_id, role_id)
    VALUES (1, 5);

INSERT INTO user_role(
    user_id, role_id)
    VALUES (2, 3);

INSERT INTO user_role(
    user_id, role_id)
    VALUES (3, 3);

INSERT INTO user_role(
    user_id, role_id)
    VALUES (4, 3);

INSERT INTO user_role(
    user_id, role_id)
    VALUES (5, 3);

INSERT INTO firm(
    id, cid, name)
    VALUES (nextval('company_id_seq'), '123456', 'PICICI DOO');