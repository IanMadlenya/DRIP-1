
package org.drip.sample.measure;

import org.drip.analytics.date.*;
import org.drip.measure.continuousmarginal.BrokenDateBridgeBrownian3P;
import org.drip.quant.common.FormatUtil;
import org.drip.service.env.EnvManager;

/*
 * -*- mode: java; tab-width: 4; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 */

/*!
 * Copyright (C) 2017 Lakshmi Krishnamurthy
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
 * BrownianBridgeConvex demonstrates using the Brownian Bridge Scheme to Interpolate Three Convex Value
 *  Points.
 *
 * @author Lakshmi Krishnamurthy
 */

public class BrownianBridgeConvex {

	public static final void main (
		final String[] astrArgs)
		throws Exception
	{
		EnvManager.InitEnv ("");

		JulianDate dt1 = DateUtil.CreateFromYMD (
			2015,
			DateUtil.JULY,
			1
		);

		JulianDate dt2 = DateUtil.CreateFromYMD (
			2015,
			DateUtil.AUGUST,
			1
		);

		JulianDate dt3 = DateUtil.CreateFromYMD (
			2015,
			DateUtil.SEPTEMBER,
			1
		);

		double dblV1 = 10.;
		double dblV2 =  5.;
		double dblV3 = 20.;

		int iDaysStep = 2;

		BrokenDateBridgeBrownian3P tpbb = new BrokenDateBridgeBrownian3P (
			dt1.julian(),
			dt2.julian(),
			dt3.julian(),
			dblV1,
			dblV2,
			dblV3
		);

		System.out.println();

		System.out.println ("\t||--------------------------||");

		System.out.println ("\t||  BROWNIAN BRIDGE CONVEX  ||");

		System.out.println ("\t||--------------------------||");

		System.out.println (
			"\t|| [" + dt1 + "] => " +
			FormatUtil.FormatDouble (tpbb.interpolate (dt1.julian()), 2, 3, 1.) + " ||"
		);

		JulianDate dt = dt1.addDays (iDaysStep);

		while (dt.julian() < dt3.julian()) {
			System.out.println (
				"\t|| [" + dt + "] => " +
				FormatUtil.FormatDouble (tpbb.interpolate (dt.julian()), 2, 3, 1.) + " ||"
			);

			dt = dt.addDays (iDaysStep);
		}

		System.out.println (
			"\t|| [" + dt3 + "] => " +
			FormatUtil.FormatDouble (tpbb.interpolate (dt3.julian()), 2, 3, 1.) + " ||"
		);

		System.out.println ("\t||--------------------------||");

		System.out.println();
	}
}
