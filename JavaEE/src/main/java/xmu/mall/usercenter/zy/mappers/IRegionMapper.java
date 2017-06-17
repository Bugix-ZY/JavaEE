package xmu.mall.usercenter.zy.mappers;

import java.util.List;

import xmu.mall.usercenter.zy.model.Region;

public interface IRegionMapper {
	List<Region> getRegionListByParentId(int id);
}
