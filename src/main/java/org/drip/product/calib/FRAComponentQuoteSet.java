
package org.drip.product.calib;

/*
 * -*- mode: java; tab-width: 4; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 */

/*!
 * Copyright (C) 2017 Lakshmi Krishnamurthy
 * Copyright (C) 2016 Lakshmi Krishnamurthy
 * Copyright (C) 2015 Lakshmi Krishnamurthy
 * Copyright (C) 2014 Lakshmi Krishnamurthy
 * 
 *  This file is part of DRIP, a free-software/open-source library for buy/side financial/trading model
 *  	libraries targeting analysts and developers
 *  	https://lakshmidrip.github.io/DRIP/
 *  
 *  DRIP is composed of four main libraries:
 *  
 *  - DRIP Fixed Income - https://lakshmidrip.github.io/DRIP-Fixed-Income/
 *  - DRIP Asset Allocation - https://lakshmidrip.github.io/DRIP-Asset-Allocation/
 *  - DRIP Numerical Optimizer - https://lakshmidrip.github.io/DRIP-Numerical-Optimizer/
 *  - DRIP Statistical Learning - https://lakshmidrip.github.io/DRIP-Statistical-Learning/
 * 
 *  - DRIP Fixed Income: Library for Instrument/Trading Conventions, Treasury Futures/Options,
 *  	Funding/Forward/Overnight Curves, Multi-Curve Construction/Valuation, Collateral Valuation and XVA
 *  	Metric Generation, Calibration and Hedge Attributions, Statistical Curve Construction, Bond RV
 *  	Metrics, Stochastic Evolution and Option Pricing, Interest Rate Dynamics and Option Pricing, LMM
 *  	Extensions/Calibrations/Greeks, Algorithmic Differentiation, and Asset Backed Models and Analytics.
 * 
 *  - DRIP Asset Allocation: Library for model libraries for MPT framework, Black Litterman Strategy
 *  	Incorporator, Holdings Constraint, and Transaction Costs.
 * 
 *  - DRIP Numerical Optimizer: Library for Numerical Optimization and Spline Functionality.
 * 
 *  - DRIP Statistical Learning: Library for Statistical Evaluation and Machine Learning.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *   	you may not use this file except in compliance with the License.
 *   
 *  You may obtain a copy of the License at
 *  	http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  	distributed under the License is distributed on an "AS IS" BASIS,
 *  	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  
 *  See the License for the specific language governing permissions and
 *  	limitations under the License.
 */

/**
 * FRAComponentQuoteSet extends the ProductQuoteSet by implementing the Calibration Parameters for the FRA
 * 	Component. Currently it only exposes the FRA Rate Quote Field.
 * 
 * @author Lakshmi Krishnamurthy
 */

public class FRAComponentQuoteSet extends org.drip.product.calib.ProductQuoteSet {

	/**
	 * FRAComponentQuoteSet Constructor
	 * 
	 * @param aLSS Array of Latent State Specification
	 * 
	 * @throws java.lang.Exception Thrown if Inputs are invalid
	 */

	public FRAComponentQuoteSet (
		final org.drip.state.representation.LatentStateSpecification[] aLSS)
		throws java.lang.Exception
	{
		super (aLSS);
	}

	/**
	 * Set the FRA Rate
	 * 
	 * @param dblFRARate The FRA Rate
	 * 
	 * @return TRUE - The FRA Rate successfully set
	 */

	public boolean setFRARate (
		final double dblFRARate)
	{
		return set ("FRARate", dblFRARate);
	}

	/**
	 * Indicate if the FRA Rate Field exists
	 * 
	 * @return TRUE - FRA Rate Field Exists
	 */

	public boolean containsFRARate()
	{
		return contains ("FRARate");
	}

	/**
	 * Retrieve the FRA Rate
	 * 
	 * @return The FRA Rate
	 * 
	 * @throws java.lang.Exception Thrown if the FRA Rate Field does not exist
	 */

	public double fraRate()
		throws java.lang.Exception
	{
		return get ("FRARate");
	}

	/**
	 * Set the Par Forward Rate
	 * 
	 * @param dblParForwardRate The Par Forward Rate
	 * 
	 * @return TRUE - The Par Forward Rate successfully set
	 */

	public boolean setParForwardRate (
		final double dblParForwardRate)
	{
		return set ("ParForwardRate", dblParForwardRate);
	}

	/**
	 * Indicate if the Par Forward Rate Field exists
	 * 
	 * @return TRUE - Par Forward Rate Field Exists
	 */

	public boolean containsParForwardRate()
	{
		return contains ("ParForwardRate");
	}

	/**
	 * Retrieve the Par Forward Rate
	 * 
	 * @return The Par Forward Rate
	 * 
	 * @throws java.lang.Exception Thrown if the Par Forward Rate Field does not exist
	 */

	public double parForwardRate()
		throws java.lang.Exception
	{
		return get ("ParForwardRate");
	}
}
