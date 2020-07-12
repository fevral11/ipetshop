package ru.htp.ipetshop_ognivenko.dao;

import ru.htp.ipetshop_ognivenko.bean.Goods;
import ru.htp.ipetshop_ognivenko.bean.Supply;

public interface GoodsDao {

	boolean addGoods(Goods good) throws DaoException;// добавляем товар

	boolean deleteGoods(Goods good) throws DaoException;// меняем статус товара на удаленный

	boolean addQuantity(Integer idGoods, Supply supply) throws DaoException;// привоз товара

	boolean changePriceGoods(Goods good, Double newPrice) throws DaoException;// изменить цену товара

	boolean changeDescriptionGoods(Goods good, String newDescription) throws DaoException;// изменить описание товара

	boolean changePictureGoods(Goods good, String newPicture) throws DaoException;// изменить картинку товара

	boolean supplyGoods(Goods good, Supply supply) throws DaoException;// привоз товара

}
