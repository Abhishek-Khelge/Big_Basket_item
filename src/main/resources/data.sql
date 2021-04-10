insert into Category(Category_Name)
values('first');

insert into Category(Category_Name)
values('second');

insert into Category(Category_Name)
values('third');


INSERT INTO SUB_CATEGORY(SUB_CAT_NAME,CATEGORY_CATEGORY_ID)
VALUES('first sub-category',1);

insert into item_Category(ITEM_TAG_NAME,SUB_CATEGORY_SUB_CAT_ID )
values ('best',1);

insert into item(BRAND_ID,ITEM_BOUGHT_DATE,ITEM_DESC,ITEM_EXPIRY_DATE,ITEM_NAME,ITEM_PIC_NAME,ITEM_TYPE,CATEGORY_CATEGORY_ID,ITEM_CATEGORY_ITEM_CATEGORY_ID,SUB_CATEGORY_SUB_CAT_ID )
values(123,'12-2-1998','good item','3-4-2021','tomato','new pic','fresh',1,1,1);