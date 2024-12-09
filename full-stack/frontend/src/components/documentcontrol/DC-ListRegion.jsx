import React, {useEffect, useState} from 'react'
import {useNavigate} from "react-router-dom";
import {deleteRegion, listRegions} from "../../services/RegionService.js";

const DCListRegion = () => {

	const [regions, setRegions] = useState([])

	const navigator = useNavigate();

	useEffect(() => {
		getAllRegions();
	}, [])

	function getAllRegions() {
		listRegions().then((response) => {
			setRegions(response.data);
		}).catch(error => {
			console.log(error);
		})

		// test data to be deleted after
		// const dummyRegions = [
		// 	{ id: 1, name: "Canada" },
		// 	{ id: 2, name: "Utah" },
		// 	{ id: 3, name: "Soviet Russia"},
		// ];
		// setRegions(dummyRegions);
	}

	function back() {
		navigator('/documentcontrol');
	}

	function addNewRegion() {
		navigator('/documentcontrol/regions/add');
	}

	function updateRegion(regionId) {
		navigator(`/documentcontrol/regions/update/${regionId}`);
	}

	function removeRegion(regionId) {
		console.log(regionId);

		deleteRegion(regionId).then((response) => {
			getAllRegions();
		}).catch(error => {
			console.error(error);
		})
	}

	function subdivision(regionId) {
		console.log(regionId);
		navigator(`/documentcontrol/regions/${regionId}/subdivisions`);
	}

	return (
		<div className='container'>
			<br/>
			<h2>Regions</h2>
			<button className="btn btn-dark mb-2" onClick={addNewRegion}>Add Region</button>
			<button className="btn btn-dark mb-2" onClick={back} style={{ marginLeft: '10px' }}>Back</button>
			<table className='table table-striped table-bordered'>
				<thead>
					<tr>
						<th>Region ID</th>
						<th>Region Name</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					{
						regions.map(region =>
							<tr key={region.id}>
								<td>{region.id}</td>
								<td>{region.name}</td>
								<td>
									<button className="btn btn-dark" onClick={() => updateRegion(region.id)}>Update</button>
									<button
										className="btn btn-dark"
										onClick={() => {
											if (window.confirm("Are you sure you want to delete region " + region.id + "?")) {
												removeRegion(region.id);
											}
										}}
										style={{marginLeft: '10px'}}
									>
										Delete
									</button>
									<button className="btn btn-dark" onClick={() => subdivision(region.id)} style={{marginLeft: '10px'}}>Subdivisions</button>
								</td>
							</tr>
						)
					}
				</tbody>
			</table>
		</div>
	)
}
export default DCListRegion
