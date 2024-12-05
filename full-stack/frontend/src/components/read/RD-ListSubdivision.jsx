import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
import {getRegion, listSubdivisions} from "../../services/RegionService.js";

const RdListSubdivision = () => {

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
		navigator('/reader/regions');
	}

	function location(chopCode) {
		console.log(chopCode);
		navigator(`/reader/regions/${regionId}/subdivisions/${chopCode}/locations`);
	}

	return (
		<div className='container'><br />
			<h2>{regionName} Subdivisions</h2>
			<button className="btn btn-dark mb-2" onClick={back}>Back</button>
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
									<button className="btn btn-dark" onClick={() => location(subdivision.chopCode)}>Locations</button>
								</td>
							</tr>
						)
					}
				</tbody>
			</table>
		</div>
	)
}
export default RdListSubdivision
