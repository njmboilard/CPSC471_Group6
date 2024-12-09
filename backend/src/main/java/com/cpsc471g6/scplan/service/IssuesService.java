package com.cpsc471g6.scplan.service;

import com.cpsc471g6.scplan.dto.IssuesDto;

import java.util.List;

public interface IssuesService {
	IssuesDto createIssue(IssuesDto issuesDto);
	IssuesDto getIssueById(int issueId);
	List<IssuesDto> getIssuesByProject(int projectId);
	List<IssuesDto> getIssuesByReporter(int employeeId);
	List<IssuesDto> getAllIssues();
	IssuesDto updateIssue(int issueId, IssuesDto issuesDto);
	void deleteIssue(int issueId);
}