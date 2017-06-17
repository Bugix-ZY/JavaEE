package xmu.mall.usercenter.zy.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import xmu.mall.usercenter.zy.model.Region;

@Component
public interface IRegionMapper {
	List<Region> getRegionListByParentId(int id);
}
