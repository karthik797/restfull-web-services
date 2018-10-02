package com.restfullwebservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.restfullwebservices.model.User;

@Service
public class UserService {
	
	private static List<User> users=new ArrayList<>();
	private static int userCount=3;
	
	static {
		
		users.add(new User(1,"user-1",new Date()));
		users.add(new User(2,"user-2",new Date()));
		users.add(new User(3,"user-3",new Date()));
	}

	public List<User> findAll()
	{
		return users;
	}
	
	public User saveUser(User user)
	{
		if(user.getId()==null)
		{
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findUser(int id)
	{
		for(User user:users)
		{
			if(user.getId()==id)
			{
				return user;
			}
		}
		return null;
	}
	public User deleteById(int id)
	{
		Iterator<User> iterator= users.iterator();
		
		while(iterator.hasNext())
		{
			User user=iterator.next();
			if(user.getId()==id)
			{
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	
}

