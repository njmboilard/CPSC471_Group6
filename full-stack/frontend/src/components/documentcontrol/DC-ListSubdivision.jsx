import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
// more imports needed here

const DCListSubdivision = () => {

	const [subdivisions, setSubdivisions] = useState([]);
	const {id : regionId} = useParams();
	const [regionName, setRegionName] = useState('');

	const navigator = useNavigate();

	useEffect(() => {
		if (regionId) {
			// Fetch subdivisions
			//listSubdivisions(regionId).then((response) => {
			//	setSubdivisions(response.data);
			//}).catch(error => {
			//	console.error(error);
			//});

			// Fetch region name
			//getRegion(regionId).then((response) => {
			//	setRegionName(response.data.name);
			//}).catch(error => {
			//	console.error(error);
			//});

			// test data to be deleted after
			const dummySubdivisions = [
				{ regionID: 1, chopCode: 'BELL', name: 'Belleville' },
				{ regionID: 1, chopCode: 'WINC', name: 'Winchester' },
				{ regionID: 1, chopCode: 'REDE', name: 'Red Deer' },
			  ];
			const dummyRegionName = "Dummy Region";

			setSubdivisions(dummySubdivisions);
			setRegionName(dummyRegionName);
		}
	}, [regionId]);

	function back() {
		navigator('/documentcontrol/regions');
	}

	function addNewSubdivision() {
		navigator(`/documentcontrol/regions/${regionId}/subdivisions/add`);
	}

	function updateSubdivision(chopCode) {
		navigator(`/documentcontrol/regions/${regionId}/subdivisions/update/${chopCode}`);
	}

	function removeSubdivision(chopCode) {
		console.log(chopCode);

		// remove subdivison logic here
	}

	function location(chopCode) {
		console.log(chopCode);
		navigator(`/documentcontrol/regions/${regionId}/subdivisions/${chopCode}/locations`);
	}

	return (
		<div className='container'><br />
			<h2>{regionName} Subdivisions</h2>
			<button className="btn btn-dark mb-2" onClick={addNewSubdivision}>Add Subdivision</button>
			<button className="btn btn-dark mb-2" onClick={back} style={{ marginLeft: '10px' }}>Back</button>
			<table className='table table-striped table-bordered'>
				<thead>
					<tr>
						<th>Region ID</th>
						<th>Chop Code</th>
						<th>Subdivision Name</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					{
						subdivisions.map(subdivision =>
							<tr key={subdivision.chopCode}>
								<td>{subdivision.regionID}</td>
								<td>{subdivision.chopCode}</td>
								<td>{subdivision.name}</td>
								<td>
									<button className="btn btn-dark" onClick={() => updateSubdivision(subdivision.chopCode)}>Update</button>
									<button
										className="btn btn-dark"
										onClick={() => {
											if (window.confirm("Are you sure you want to delete subdivision " + subdivision.chopCode + "?")) {
												removeSubdivision(subdivision.chopCode);
											}
										}}
										style={{marginLeft: '10px'}}
									>
										Delete
									</button>
									<button className="btn btn-dark" onClick={() => location(subdivision.chopCode)} style={{marginLeft: '10px'}}>Locations</button>
								</td>
							</tr>
						)
					}
				</tbody>
			</table>
		</div>
	)
}
export default DCListSubdivision
