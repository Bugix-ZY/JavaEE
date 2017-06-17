package xmu.mall.usercenter.zy.service;

import java.util.List;

import org.springframework.stereotype.Component;

import xmu.mall.usercenter.zy.model.Region;

@Component
public interface IRegionService {
	public List<Region> getRegionListByParentId(int id);
}
