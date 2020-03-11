package com.sugar.wyglsystem.controller;

import com.sugar.wyglsystem.common.api.CommonPage;
import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.dto.RoomDto;
import com.sugar.wyglsystem.mbg.model.Room;
import com.sugar.wyglsystem.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/7 14:59
 * @description：
 */
@RequestMapping("/room")
@Api(tags = "RoomController", description = "房屋管理")
@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/list")
    @ApiOperation("查询所有房屋")
    public CommonResult<CommonPage<Room>> getRoomList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        System.out.println(pageSize);
        List<Room> roomList = roomService.getRoomList(pageNum, pageSize);
        if (roomList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(roomList));
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/delete/{id}")
    @ApiOperation("根据id删除")
    public CommonResult deleteRoomList(@PathVariable Long id) {
        System.out.println(id);
        int count = roomService.deleteRoomById(id);
        if (count > 0) {
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed("删除失败");
    }

    @PostMapping("/update/{id}")
    @ApiOperation("更新房屋信息")
    public CommonResult updateRoom(@PathVariable Long id, @RequestBody Room room) {
        System.out.println(room);
        int count = roomService.updateRoom(id, room);
        if (count > 0) {
            return CommonResult.success("更新成功");
        }
        return CommonResult.failed("更新失败");
    }

    @GetMapping("/")
    @ApiOperation("根据number查询房屋")
    public CommonResult getRoomByNumber(@RequestParam Long buildingNumber,
                                        @RequestParam Long unitNumber,
                                        @RequestParam Long roomNumber) {
        RoomDto roomDto = roomService.getRoomByNumber(buildingNumber, unitNumber, roomNumber);
        if (roomDto != null) {
            return CommonResult.success(roomDto);
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/{buildingNum}")
    @ApiOperation("根据楼房number查询房屋")
    public CommonResult<CommonPage<Room>> getRoomInfoByBuildingNumber(@PathVariable Long buildingNum,
                                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                      @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<Room> roomList = roomService.getRoomInfoByBuildingNumber(buildingNum, pageNum, pageSize);
        if (!roomList.isEmpty()) {
            return CommonResult.success(CommonPage.resetPage(roomList));
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/owner/{id}")
    @ApiOperation("根据业主id查询房屋")
    public CommonResult getRoomInfoByOwnerId(@PathVariable Long id) {
        RoomDto roomDto = roomService.getRoomByOwnerId(id);
        if (roomDto != null) {
            return CommonResult.success(roomDto);
        }
        return CommonResult.failed("查询失败");
    }

    @PostMapping("/add")
    @ApiOperation("新增房屋")
    public CommonResult insertRoom(@RequestBody Room room) {
        Room rs = roomService.insertRoom(room);
        if (rs != null) {
            return CommonResult.success(rs);
        }
        return CommonResult.failed("新增失败");
    }

}
