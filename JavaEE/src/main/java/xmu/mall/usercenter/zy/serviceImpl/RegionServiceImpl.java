package xmu.mall.usercenter.zy.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.zy.mapper.IRegionMapper;
import xmu.mall.usercenter.zy.model.Region;
import xmu.mall.usercenter.zy.service.IRegionService;

@Service("regionService")
@Transactional
public class RegionServiceImpl implements IRegionService {

	@Autowired
	public IRegionMapper regionMapper;
	
	public List<Region> getRegionListByParentId(int id) {
		return regionMapper.getRegionListByParentId(id);
	}

}
