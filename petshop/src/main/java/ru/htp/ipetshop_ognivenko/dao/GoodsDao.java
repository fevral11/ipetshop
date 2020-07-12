package ru.htp.ipetshop_ognivenko.dao;

import ru.htp.ipetshop_ognivenko.bean.Goods;
import ru.htp.ipetshop_ognivenko.bean.Supply;

public interface GoodsDao {

	boolean addGoods(Goods good) throws DaoException;// ��������� �����

	boolean deleteGoods(Goods good) throws DaoException;// ������ ������ ������ �� ���������

	boolean addQuantity(Integer idGoods, Supply supply) throws DaoException;// ������ ������

	boolean changePriceGoods(Goods good, Double newPrice) throws DaoException;// �������� ���� ������

	boolean changeDescriptionGoods(Goods good, String newDescription) throws DaoException;// �������� �������� ������

	boolean changePictureGoods(Goods good, String newPicture) throws DaoException;// �������� �������� ������

	boolean supplyGoods(Goods good, Supply supply) throws DaoException;// ������ ������

}
