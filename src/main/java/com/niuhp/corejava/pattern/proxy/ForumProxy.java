package com.niuhp.corejava.pattern.proxy;

public class ForumProxy implements Forum {
	private ForumPermissions forumPermissions;
	private Forum forum;
	@SuppressWarnings("unused")
	private Authorization authorization;

	public ForumProxy(ForumPermissions forumPermissions, Forum forum, Authorization authorization) {
		this.forumPermissions = forumPermissions;
		this.forum = forum;
		this.authorization = authorization;
	}

	@Override
	public void setName(String name) {
		if (forumPermissions.isSystemOrForumAdmin()) {
			forum.setName(name);
		} else {
			// throw NoPermissionException
		}

	}

}
